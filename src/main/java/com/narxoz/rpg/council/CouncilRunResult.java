package com.narxoz.rpg.council;

public class CouncilRunResult {
    private final int questsTraversed;
    private final int messagesRouted;
    private final int membersNotified;

    public CouncilRunResult(int q, int m, int n) {
        this.questsTraversed = q;
        this.messagesRouted = m;
        this.membersNotified = n;
    }

    @Override
    public String toString() {
        return "Council Summary: Quests=" + questsTraversed +
                ", Messages=" + messagesRouted +
                ", Total Notifications=" + membersNotified;
    }
}