-------------------------------------------------- -------------------------------------------------- -
Objective: create a service and evaluate the access time to it, depending on the input parameters
-------------------------------------------------- -------------------------------------------------- -

-------------------------------------------------- -------------------------------------------------- -
1. Create a service with the following interface:
-------------------------------------------------- -------------------------------------------------- -
public interface AccountService
{
    / **
     * Retrieves current balance or zero if addAmount () method was not called before for specified id
     *
     * @param id balance identifier
     * /
    Long getAmount (Integer id);

    / **
     * Increases balance or set if addAmount () method was called first time
     *
     * @param id balance identifier
     * @param value positive or negative value, which must be added to current balance
     * /
    void addAmount (Integer id, Long value);
}

The service will operate in a highly loaded fault tolerant system.

The service must cache data in memory and store data in the database (Oracle, PostgreSQL, MySQL)
or throwing Exception if the operation failed.

As a transport layer, you can choose any of the protocols RMI, Hessian, HTTP

-------------------------------------------------- -------------------------------------------------- -
2. Create a test client
-------------------------------------------------- -------------------------------------------------- -
The test client must be able to run several competitive threads on a specific subset of identifiers
  - rCount - the number of readers calling the getAmount (id) method
  - wCount - the number of readers calling the addAmount (id, value) method
  - idList - list or range of keys that will be used for testing
These parameters can be set via the command line or configuration file.

At the same time, you can run several test clients on the same or different computers.

-------------------------------------------------- -------------------------------------------------- -
3. Get statistics processing requests on the server AccountService'om
-------------------------------------------------- -------------------------------------------------- -
For each of the two methods of AccountService (getAmount, addAmount) you need to get
  - the number of requests processed per unit time on the server (!!! not on the client)
  - total number of requests from all clients
  
Statistics from the service can be obtained on demand in any way
or dump to the log with a certain frequency.
Provide the ability to reset statistics to zero on a running service.
