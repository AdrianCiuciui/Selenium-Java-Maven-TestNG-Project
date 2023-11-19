# Selenium-Java
Automation project for https://www.saucedemo.com

This project is closely related to https://github.com/AdrianCiuciui/Playwright-Typescript. 
They both handle the same demo website and their tests cover similar flows.

There are some login tests and two e2e tests. They can be found in the Test classes.
What they cover:
- the core business flow: placing a product in the cart and performing checkout with it
- products are added to the cart from the Products and Product details page
- the sums are verified for mathematically correctness, a tax is also present

Steps (helper) classes are used.

The webdriver is handled so that there is no need to add it when creating new objects from the POM classes.

The application is mapped with: ID, className and xpath. This was also the preferred choice of locating the web elements.

Random product(s) (are) is selected at each run.

GitHub Actions is set up and running. It runs all the tests automatically when pushing into the master branch.
