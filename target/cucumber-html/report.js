$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/Login.feature");
formatter.feature({
  "name": "This feature will verify the login functionality of SWAGLABS",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@LoginFeature"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Verify login functionality to SWAGLABS using correct username and password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@PositiveLogin"
    }
  ]
});
formatter.step({
  "name": "User launchs the SWAGLABS application",
  "keyword": "Given "
});
formatter.step({
  "name": "User enters \u0027\u003cUserName\u003e\u0027 and \u0027\u003cPassword\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "name": "User clicks the LOGIN button",
  "keyword": "And "
});
formatter.step({
  "name": "User should be landed on the Products Page",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "UserName",
        "Password"
      ]
    },
    {
      "cells": [
        "standard_user",
        "secret_sauce"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify login functionality to SWAGLABS using correct username and password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@LoginFeature"
    },
    {
      "name": "@PositiveLogin"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User launchs the SWAGLABS application",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.user_launchs_the_swaglabs_application()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat stepDefs.LoginSteps.user_launchs_the_swaglabs_application(LoginSteps.java:45)\n\tat ✽.User launchs the SWAGLABS application(file:src/test/java/features/Login.feature:6)\n",
  "status": "failed"
});
formatter.step({
  "name": "User enters \u0027standard_user\u0027 and \u0027secret_sauce\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.user_enters_and_(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User clicks the LOGIN button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.user_clicks_the_login_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User should be landed on the Products Page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_should_be_landed_on_the_products_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verify login functionality to SWAGLABS using incorrect username and password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@NegativeLogin"
    }
  ]
});
formatter.step({
  "name": "User launchs the SWAGLABS application",
  "keyword": "Given "
});
formatter.step({
  "name": "User enters \u0027\u003cUsername\u003e\u0027 and \u0027\u003cPassword\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "name": "User clicks the LOGIN button",
  "keyword": "And "
});
formatter.step({
  "name": "User should be getting the \u0027\u003cErrorMsg\u003e\u0027",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "ErrorMsg"
      ]
    },
    {
      "cells": [
        "unknown",
        "wrong123!",
        "Epic sadface: Username and password do not match any user in this service"
      ]
    },
    {
      "cells": [
        "locked_out_user",
        "secret_sauce",
        "Epic sadface: Sorry, this user has been locked out."
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify login functionality to SWAGLABS using incorrect username and password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@LoginFeature"
    },
    {
      "name": "@NegativeLogin"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User launchs the SWAGLABS application",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.user_launchs_the_swaglabs_application()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat stepDefs.LoginSteps.user_launchs_the_swaglabs_application(LoginSteps.java:45)\n\tat ✽.User launchs the SWAGLABS application(file:src/test/java/features/Login.feature:17)\n",
  "status": "failed"
});
formatter.step({
  "name": "User enters \u0027unknown\u0027 and \u0027wrong123!\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.user_enters_and_(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User clicks the LOGIN button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.user_clicks_the_login_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User should be getting the \u0027Epic sadface: Username and password do not match any user in this service\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_should_be_getting_the_(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify login functionality to SWAGLABS using incorrect username and password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@LoginFeature"
    },
    {
      "name": "@NegativeLogin"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User launchs the SWAGLABS application",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.user_launchs_the_swaglabs_application()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat stepDefs.LoginSteps.user_launchs_the_swaglabs_application(LoginSteps.java:45)\n\tat ✽.User launchs the SWAGLABS application(file:src/test/java/features/Login.feature:17)\n",
  "status": "failed"
});
formatter.step({
  "name": "User enters \u0027locked_out_user\u0027 and \u0027secret_sauce\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.user_enters_and_(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User clicks the LOGIN button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.user_clicks_the_login_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User should be getting the \u0027Epic sadface: Sorry, this user has been locked out.\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_should_be_getting_the_(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});