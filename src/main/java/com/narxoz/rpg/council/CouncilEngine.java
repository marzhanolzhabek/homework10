package com.narxoz.rpg.council;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.*;
import java.util.List;

public class CouncilEngine {
    public CouncilRunResult runCouncil(List<Hero> party, QuestLog log, GuildMediator hall) {
        int qCount = 0;
        int mCount = 0;
        int nCount = 0;

        System.out.println("\n--- Reviewing Urgent Quests (Priority Iterator) ---");
        QuestIterator it1 = log.priorityAtLeast(QuestPriority.HIGH);
        while (it1.hasNext()) {
            Quest q = it1.next();
            qCount++;
            System.out.println("Council analyzing: " + q.getTitle());
            hall.dispatch("urgent", null, "URGENT ACTION NEEDED: " + q.getTitle());
            mCount++;
            if (hall instanceof GuildHall) nCount += ((GuildHall) hall).getLastDispatchCount();
        }

        System.out.println("\n--- Planning General Logistics (Ordered Iterator) ---");
        QuestIterator it2 = log.ordered();
        while (it2.hasNext()) {
            Quest q = it2.next();
            qCount++;
            hall.dispatch("supplies", null, "Resource planning for: " + q.getTitle());
            mCount++;
            if (hall instanceof GuildHall) nCount += ((GuildHall) hall).getLastDispatchCount();
        }

        return new CouncilRunResult(qCount, mCount, nCount);
    }
}