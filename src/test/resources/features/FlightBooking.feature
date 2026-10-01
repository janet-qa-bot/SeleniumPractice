@Smoke
Feature: Flight booking

As an airline customer
I want to search for and purchase a flight
So that I can receive a booking confirmation

Scenario Outline: Customer successfully books a flight
    Given the customer is on the BlazeDemo home page
    When the customer selects "<departureCity>" as the departure city
    And the customer selects "<destinationCity>" as the destination city
    And the customer searches for flights
    Then flights from "<departureCity>" to "<destinationCity>" should be displayed
    When the customer choose the first available flight
    And the customer enters valid passenger and payment information
    And the customer completes the purchase
    Then the booking confirmation should be displayed

    Examples:
    | departureCity | destinationCity |
    | Boston        | London          |
    | Portland      | Berlin          |

