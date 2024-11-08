Spring Testing homework

1. Turn booking service controllers into REST endpoints, returning domain objects directly intead of ModelAndView objects (30 points)

2. Implement asynchronous ticket booking. Create JMS consumer which will listen to a particular queue, receive booking messages and process them by adding appropriate database records. (30 points)

3. Configure Spring JMS infrastructure (10 point)

4. Create integration tests that verify asynchronous booking, mock JMS provider using at least 2 of the approaches shown during last Spring Test lecture. (30 points)

Extra mile:

1. Implement BDD-style unit tests using one of the BDD testing frameworks.

2. Use dynamic JVM language of your choice to implement BDD tests
