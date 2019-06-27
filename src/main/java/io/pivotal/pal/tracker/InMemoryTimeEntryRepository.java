package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();
    private Long timeEntryCount = 1L;
    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long id = timeEntryCount++;
        TimeEntry newTimeEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        timeEntries.put(id, newTimeEntry);
        return newTimeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return timeEntries.get(timeEntryId);
    }

    @Override
    public TimeEntry update(long timeEntryId, TimeEntry entry) {
        if(find(timeEntryId) == null) {
            return null;
        }
        TimeEntry updatedEntry = new TimeEntry(
                timeEntryId,
                entry.getProjectId(),
                entry.getUserId(),
                entry.getDate(),
                entry.getHours()
        );

        timeEntries.replace(timeEntryId, updatedEntry);
        return updatedEntry;
    }

    @Override
    public void delete(long timeEntryId) {
         timeEntries.remove(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }
}
