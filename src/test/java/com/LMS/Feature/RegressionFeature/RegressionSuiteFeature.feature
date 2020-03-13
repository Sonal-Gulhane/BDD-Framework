@regression
Feature: GCE regression suite

  Background:
    Given User open the browser
    When User navigates to GCE homepage

  Scenario: About submenu validation
    Then user hovers on About menu
    Then validate submenu "Sustainability" and "Service Model"
    Then close the browser

  Scenario: Validate serviceModel Menu Page Load
    Then user hovers on About menu
    Then user clicks on ServiceModel submenu
    Then validates ServiceModel load "The GCE Full-Service Model"
    Then close the browser

  Scenario: Validate Procurement Department
    Then user hovers on About menu
    Then user clicks on ServiceModel submenu
    Then validates ServiceModel load "The GCE Full-Service Model"
    Then user clicks on DoingBusiness Link
    Then click on SupplierCodeOfConduct Link
    Then Validate the pdfLoad for SupplierCodeOfConduct
    Then close the browser
