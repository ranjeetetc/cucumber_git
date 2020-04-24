$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("toolsQA.feature");
formatter.feature({
  "line": 1,
  "name": "Toolsqa examples",
  "description": "",
  "id": "toolsqa-examples",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "setup the browser and declare variable",
  "description": "",
  "id": "toolsqa-examples;setup-the-browser-and-declare-variable",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user set preference and launch \"https://demoqa.com/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I drag and drop",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I test the working of selectable",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I test the working of resizeable",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I test the working of Dropable",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I test the working of Dragable",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I test the working of Switch window",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I test the working of switch message window",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I test the working of message tab",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I test the working of table",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I test the working of iFrame",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I test the working of form",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I test the working of html contact",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I test the working of keyboard event",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "I test the working of Double click",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I test the working of tooltip",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I close the browser",
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "https://demoqa.com/",
      "offset": 32
    }
  ],
  "location": "stepDefination.user_set_preference_and_launch_something(String)"
});
formatter.result({
  "duration": 7506318700,
  "error_message": "org.openqa.selenium.WebDriverException: Failed to decode response from marionette\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-AUMHBJJ\u0027, ip: \u0027192.168.18.26\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_172\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities {acceptInsecureCerts: true, browserName: firefox, browserVersion: 75.0, javascriptEnabled: true, moz:accessibilityChecks: false, moz:buildID: 20200403170909, moz:geckodriverVersion: 0.26.0, moz:headless: false, moz:processID: 20136, moz:profile: C:\\Users\\LENOVO\\AppData\\Loc..., moz:shutdownTimeout: 60000, moz:useNonSpecCompliantPointerOrigin: false, moz:webdriverClick: true, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, platformVersion: 10.0, rotatable: false, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 944109fe-cb5f-4f7d-9dea-3146e411c94c\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver$RemoteWebDriverOptions$RemoteWindow.maximize(RemoteWebDriver.java:837)\r\n\tat stepDefinations.stepDefination.user_set_preference_and_launch_something(stepDefination.java:70)\r\n\tat ✽.Given user set preference and launch \"https://demoqa.com/\"(toolsQA.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "stepDefination.i_drag_and_drop_text_1_and_text()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_selectable()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_resizeable()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_dropable()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_dragable()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_switch_window()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_switch_message_window()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_message_tab()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_table()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_iframe()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_form()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_html_contact()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_keyboard_event()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_double_click()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_test_the_working_of_tooltip()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefination.i_close_the_browser()"
});
formatter.result({
  "status": "skipped"
});
});