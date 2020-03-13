$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SmokeFeature/GCEcontactPageFeature.feature");
formatter.feature({
  "line": 1,
  "name": "Enter contact details on GCE contact Page",
  "description": "",
  "id": "enter-contact-details-on-gce-contact-page",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Mandatory field validation on Contact Page",
  "description": "",
  "id": "enter-contact-details-on-gce-contact-page;mandatory-field-validation-on-contact-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "User Clicks on Contact Menu on HomePage",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "enter details in contact form \"\u003cname\u003e\",\"\u003cemail\u003e\",\"\u003cphone\u003e\",\"\u003ccompany\u003e\",\"\u003csubject\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user clicks on submit button",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "validate the error message \"This field is required.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "enter-contact-details-on-gce-contact-page;mandatory-field-validation-on-contact-page;",
  "rows": [
    {
      "cells": [
        "name",
        "email",
        "phone",
        "company",
        "subject"
      ],
      "line": 18,
      "id": "enter-contact-details-on-gce-contact-page;mandatory-field-validation-on-contact-page;;1"
    },
    {
      "comments": [
        {
          "line": 19,
          "value": "##@externaldata@./src/main/resources/datasheets/testData.xlsx@Sheet1"
        }
      ],
      "cells": [
        "Rajni Ranjan",
        "rajni.ranjan@clairvoyantsoft.com",
        "4322305947",
        "Clairvoyant",
        "Other"
      ],
      "line": 20,
      "id": "enter-contact-details-on-gce-contact-page;mandatory-field-validation-on-contact-page;;2"
    },
    {
      "cells": [
        "Test name",
        "abc@gmail.com",
        "1234567890",
        "abc company",
        "Investor Relations"
      ],
      "line": 21,
      "id": "enter-contact-details-on-gce-contact-page;mandatory-field-validation-on-contact-page;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "User open the browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User navigates to GCE homepage",
  "keyword": "When "
});
formatter.match({
  "location": "GenericStep.userOpenTheBrowser()"
});
formatter.result({
  "duration": 11474581500,
  "status": "passed"
});
formatter.match({
  "location": "GenericStep.userNavigatesToGCEHomepage()"
});
formatter.result({
  "duration": 9152106400,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 19,
      "value": "##@externaldata@./src/main/resources/datasheets/testData.xlsx@Sheet1"
    }
  ],
  "line": 20,
  "name": "Mandatory field validation on Contact Page",
  "description": "",
  "id": "enter-contact-details-on-gce-contact-page;mandatory-field-validation-on-contact-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "User Clicks on Contact Menu on HomePage",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "enter details in contact form \"Rajni Ranjan\",\"rajni.ranjan@clairvoyantsoft.com\",\"4322305947\",\"Clairvoyant\",\"Other\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user clicks on submit button",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "validate the error message \"This field is required.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "testFeatureStep.userClicksOnContactMenuOnHomePage()"
});
formatter.result({
  "duration": 91415700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Rajni Ranjan",
      "offset": 31
    },
    {
      "val": "rajni.ranjan@clairvoyantsoft.com",
      "offset": 46
    },
    {
      "val": "4322305947",
      "offset": 81
    },
    {
      "val": "Clairvoyant",
      "offset": 94
    },
    {
      "val": "Other",
      "offset": 108
    }
  ],
  "location": "ContactPageSteps.enterDetailsInContactForm(String,String,String,String,String)"
});
formatter.result({
  "duration": 820107700,
  "status": "passed"
});
formatter.match({
  "location": "ContactPageSteps.userClicksOnSubmitButton()"
});
formatter.result({
  "duration": 2105352100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This field is required.",
      "offset": 28
    }
  ],
  "location": "ContactPageSteps.validateTheErrorMessage(String)"
});
formatter.result({
  "duration": 61826100,
  "status": "passed"
});
formatter.match({
  "location": "GenericStep.closeTheBrowser()"
});
formatter.result({
  "duration": 765206800,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "User open the browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User navigates to GCE homepage",
  "keyword": "When "
});
formatter.match({
  "location": "GenericStep.userOpenTheBrowser()"
});
formatter.result({
  "duration": 9756144300,
  "status": "passed"
});
formatter.match({
  "location": "GenericStep.userNavigatesToGCEHomepage()"
});
formatter.result({
  "duration": 8990474800,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Mandatory field validation on Contact Page",
  "description": "",
  "id": "enter-contact-details-on-gce-contact-page;mandatory-field-validation-on-contact-page;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "User Clicks on Contact Menu on HomePage",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "enter details in contact form \"Test name\",\"abc@gmail.com\",\"1234567890\",\"abc company\",\"Investor Relations\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user clicks on submit button",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "validate the error message \"This field is required.\"",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "testFeatureStep.userClicksOnContactMenuOnHomePage()"
});
formatter.result({
  "duration": 76602100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Test name",
      "offset": 31
    },
    {
      "val": "abc@gmail.com",
      "offset": 43
    },
    {
      "val": "1234567890",
      "offset": 59
    },
    {
      "val": "abc company",
      "offset": 72
    },
    {
      "val": "Investor Relations",
      "offset": 86
    }
  ],
  "location": "ContactPageSteps.enterDetailsInContactForm(String,String,String,String,String)"
});
formatter.result({
  "duration": 683864300,
  "status": "passed"
});
formatter.match({
  "location": "ContactPageSteps.userClicksOnSubmitButton()"
});
formatter.result({
  "duration": 2088832900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "This field is required.",
      "offset": 28
    }
  ],
  "location": "ContactPageSteps.validateTheErrorMessage(String)"
});
formatter.result({
  "duration": 63603200,
  "status": "passed"
});
formatter.match({
  "location": "GenericStep.closeTheBrowser()"
});
formatter.result({
  "duration": 747756100,
  "status": "passed"
});
});