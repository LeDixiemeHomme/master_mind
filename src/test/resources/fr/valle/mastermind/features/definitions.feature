Feature: Definitions

  @default_sequences
  Scenario: Default sequences
    Then the available sequences should be at least:
      | name       | color_1 | color_2 | color_3 | color_4 |
      | sequence_1 | blue    | red     | green   | blue    |
      | sequence_2 | green   | red     | yellow  | yellow  |
      | sequence_3 | green   | red     | yellow  | yellow  |
      | sequence_4 | green   | green   | green   | green   |
      | sequence_5 | green   | yellow  | yellow  | yellow  |
      | sequence_6 | yellow  | red     | red     | red     |
