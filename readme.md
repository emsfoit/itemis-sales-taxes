# Sales Tax Calculator

This Java backend application solves a common sales tax calculation problem. It provides a single endpoint, `/getInvoice`, that accepts an array of strings, with each string representing an invoice item. Each invoice item contains information such as the product count, price, and name.

## Required versions
1. **Java**: Amazon Corretto 17.0.8.1 (JDK)
2. **Gradle**: Version 8.2
## Usage and Build Instructions

To use this application, follow these steps:


### Cloning the Repository
   ```git clone https://github.com/emsfoit/itemis-sales-taxes.git```

### Setting Up in IntelliJ IDEA

1. **Open the project in IntelliJ IDEA.**

2. **Import the Gradle Project:**

   - Go to "File" -> "New" -> "Project from Existing Sources."
   - Select the `build.gradle` or `build.gradle.kts` file in your project directory and click "OK."
### Running the Application

   - If your application has a main class that needs to be executed, locate and select it.
   - Go to the "Run" menu and select "Run," or press `Shift + F10` (Windows/Linux) or `Ctrl + R` (Mac) to start your application.

By default, the Spring server runs on port 8080, and you can access the `/getInvoice` endpoint at `http://localhost:8080/getInvoice`.

## Classes

The application comprises two main classes:

### Invoice class

This class manages multiple invoice items and defines tax rates for both imported and normal goods. The `toString` method is overridden to generate the final invoice based on the provided input.

### Invoice Item class

In this class, a string input is processed to extract information such as product count, name, price, and tax status (whether the product is tax-free or not). The `isTaxFree` function determines the tax-free status based on a static list stored in the `taxfree_items.txt` file.

## Testing

A test suite has been created to validate the application's functionality. It uses various input scenarios to verify that the `/getInvoice` endpoint returns the expected results.


