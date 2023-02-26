@smoke
Feature: F04_search | users could use search functionality to find items

  Scenario Outline: user could search for products by name
    And user enter "<product_name>" in search field
    When user press on search button
    Then user check search by "<name>" "<results>"

    Examples:
    |product_name| name|results|
    |book        |book |6      |
    |laptop      |laptop|  2    |
    |nike        |nike  |  3    |

  Scenario Outline: user could search for products by sku
    And user enter product "<sku>"
    When user press on search button
    Then check search by sku "<results>"
    Examples:
    |sku|results|
    |SCI_FAITH|SCI_FAITH |
    |APPLE_CAM| APPLE_CAM|
    |SF_PRO_11|SF_PRO_11 |

