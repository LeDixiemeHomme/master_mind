Feature: show the number of well placed color in a sequence

  Scenario: Returning a good number of well placed color
    Given The color sequence to guess red blue blue blue
    When The color sequence proposed is red green green green
    Then The number of well placed color should be equal to 1
