Feature: Enter contact details on GCE contact Page

  Background:
    Given User open the browser
    When User navigates to GCE homepage

  @smoke
  Scenario Outline: Mandatory field validation on Contact Page

    When User Clicks on Contact Menu on HomePage
    Then enter details in contact form "<name>","<email>","<phone>","<company>","<subject>"
    Then user clicks on submit button
    Then validate the error message "This field is required."
    Then close the browser


    Examples:
      | name         | email                            | phone      | company     | subject |
      ##@externaldata@./src/main/resources/datasheets/testData.xlsx@Sheet1
|Rajni Ranjan|rajni.ranjan@clairvoyantsoft.com|4322305947|Clairvoyant|Other|
|Test name|abc@gmail.com|1234567890|abc company|Investor Relations|

  Scenario Outline: Contact details test using dataprovider
    When User Clicks on Contact Menu on HomePage
    Then user enters details on contact page <Contactname>
    Then close the browser

    Examples:
      | Contactname |
      | test        |
      | Rajni       |


  Scenario Outline: Contact details test using external dataprovider

    When User Clicks on Contact Menu on HomePage
    Then user enters details on contact page <Contactname>
    Then close the browser

    Examples:
      | Contactname |
      ##@externaldata@./src/main/resources/datasheets/testData.xlsx@Sheet3
|Rajni|
|Atul|
|Sudhir|




