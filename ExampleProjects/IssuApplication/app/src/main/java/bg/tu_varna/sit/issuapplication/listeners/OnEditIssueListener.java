package bg.tu_varna.sit.issuapplication.listeners;

import bg.tu_varna.sit.issuapplication.models.Issue;

public interface OnEditIssueListener {
    void onAddIssue(Issue issue);
    void onEditIssue(Issue issue);
}
