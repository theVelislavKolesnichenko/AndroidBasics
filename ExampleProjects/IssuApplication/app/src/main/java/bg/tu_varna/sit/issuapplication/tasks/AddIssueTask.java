package bg.tu_varna.sit.issuapplication.tasks;

import java.util.List;
import java.util.Random;

import bg.tu_varna.sit.issuapplication.listeners.OnEditIssueListener;
import bg.tu_varna.sit.issuapplication.models.Issue;
import bg.tu_varna.sit.issuapplication.models.Person;

public class AddIssueTask implements Runnable {
    private final OnEditIssueListener listener;

    public AddIssueTask(OnEditIssueListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        int number = 0;
        do {
            number++;
            Random random = new Random();
            try {
                Thread.sleep((3 + random.nextInt(7)) * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            listener.onAddIssue(new Issue(new Person(
                            String.format("Person %d", number),
                            String.format("088 %d", number)
                    ),
                            String.format("Description %d", number),
                            String.format("Address %d", number)
                    )
            );
        } while (true);
    }
}
