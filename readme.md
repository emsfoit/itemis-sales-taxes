# Sales Tax Calculator

This Java backend application solves a common sales tax calculation problem. It provides a single endpoint, `/getInvoice`, that accepts an array of strings, with each string representing an invoice item. Each invoice item contains information such as the product count, price, and name.

## Usage

To use this application, follow these steps:

1. Clone this repository to your local machine.
2. Install the required packages specified in the `build.gradle` file.
3. Run the application using your preferred Java compiler (e.g., IntelliJ IDEA or any Java IDE).

By default, the Spring server runs on port 8080, and you can access the `/getInvoice` endpoint at `http://localhost:8080/getInvoice`.

## Classes

The application comprises two main classes:

### Invoice class

This class manages multiple invoice items and defines tax rates for both imported and normal goods. The `toString` method is overridden to generate the final invoice based on the provided input.

### Invoice Item class

In this class, a string input is processed to extract information such as product count, name, price, and tax status (whether the product is tax-free or not). The `isTaxFree` function determines the tax-free status based on a static list stored in the `taxfree_items.txt` file.

## Testing

A test suite has been created to validate the application's functionality. It uses various input scenarios to verify that the `/getInvoice` endpoint returns the expected results.


