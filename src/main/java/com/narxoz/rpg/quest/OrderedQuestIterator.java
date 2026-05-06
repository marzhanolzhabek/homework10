package com.narxoz.rpg.quest;
import java.util.List;

public class OrderedQuestIterator implements QuestIterator {
    private final List<Quest> snapshot;
    private int cursor = 0;

    public OrderedQuestIterator(QuestLog questLog) {
        this.snapshot = questLog.snapshot();
    }

    @Override
    public boolean hasNext() { return cursor < snapshot.size(); }

    @Override
    public Quest next() { return snapshot.get(cursor++); }
}