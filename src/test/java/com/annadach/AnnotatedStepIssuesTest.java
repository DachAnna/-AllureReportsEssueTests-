package com.annadach;

import org.junit.jupiter.api.Test;


public class AnnotatedStepIssuesTest {

    private final static String REPOSITORY = "DachAnna/AllureReportsIssuesTests";
    private final static Integer ISSUE_NUMBER = 1;

    @Test
    public void testRepositoryIssue() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
