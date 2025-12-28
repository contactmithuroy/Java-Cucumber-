@tag
Feature: Testing Cucumber Project Setup

  @test1
  Scenario: Verify Cucumber framework setup
    Given user is on homepage

  @test2
  Scenario: Verify Cucumber login setup
    Given user is on loginPage
    Then user click on lgoin button