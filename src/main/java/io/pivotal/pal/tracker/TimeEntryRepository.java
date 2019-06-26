package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry entry);
    TimeEntry find(long timeEntryId);
    TimeEntry update(long timeEntryId, TimeEntry entry);
    TimeEntry delete(long timeEntryId);
    List<TimeEntry> list();
}
