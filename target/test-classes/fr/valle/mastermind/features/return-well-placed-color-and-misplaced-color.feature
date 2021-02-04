@default_sequences
Feature: show the number of well placed color and the number of correct but misplaced color from a sequence

  Scenario Outline: Returning a good number of correct but misplaced color and a good number of well placed color
    Given The color sequence to guess <sequence to guess>
    And The proposed color sequence <proposed sequence>
    When The answerer compare the two sequences
    Then The number of well placed color returned should be equal to <number of well placed color>
    And the number of correct but misplaced color returned should be equal to <number of correct but misplaced color>
    Examples:
      | sequence to guess | proposed sequence | number of well placed color | number of correct but misplaced color |
      | "sequence_1"      | "sequence_2"      | 1                           | 1                                     |
      | "sequence_2"      | "sequence_3"      | 4                           | 0                                     |
      | "sequence_4"      | "sequence_5"      | 1                           | 0                                     |
      | "sequence_5"      | "sequence_6"      | 0                           | 1                                     |
