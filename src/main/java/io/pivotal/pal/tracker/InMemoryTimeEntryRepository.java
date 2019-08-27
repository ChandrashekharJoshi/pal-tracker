package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> timeEntryData = new HashMap<Long, TimeEntry>();
    long index = 0;

    @Override
    public TimeEntry create(TimeEntry timeEntryToCreate) {
        timeEntryToCreate.setId(++index);
        timeEntryData.put(index, timeEntryToCreate);
        return timeEntryData.get(index);
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return timeEntryData.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntryData.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry updatedEntry) {
        if(timeEntryData.containsKey(id)) {
            updatedEntry.setId(id);
            timeEntryData.put(id, updatedEntry);
            return timeEntryData.get(id);
        }
        return null;
    }

    @Override
    public boolean delete(long timeEntryId) {
        timeEntryData.remove(timeEntryId);
        return timeEntryData.get(timeEntryId) == null ? true : false;
    }

}
