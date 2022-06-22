We can perform authentication in filter. Here, we are going to check to password given by the user in filter class, if given password is admin,
it will forward the request to the WelcomeAdmin servlet otherwise it will display error message.

Example of authenticating user using filter

Let's see the simple example of authenticating user using filter.

Here, we have created 4 files:
    index.html
    MyFilter.java
    AdminServlet.java
    web.xml
