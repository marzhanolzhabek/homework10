package com.narxoz.rpg.quest;
import java.util.ArrayList;
import java.util.List;

public class PriorityQuestIterator implements QuestIterator {
    private final List<Quest> snapshot;
    private int cursor = 0;

    public PriorityQuestIterator(QuestLog questLog, QuestPriority threshold) {
        QuestPriority min = (threshold == null) ? QuestPriority.LOW : threshold;
        this.snapshot = new ArrayList<>();
        for (Quest q : questLog.snapshot()) {
            if (q.getPriority().ordinal() >= min.ordinal()) {
                snapshot.add(q);
            }
        }
    }

    @Override
    public boolean hasNext() { return cursor < snapshot.size(); }

    @Override
    public Quest next() { return snapshot.get(cursor++); }
}