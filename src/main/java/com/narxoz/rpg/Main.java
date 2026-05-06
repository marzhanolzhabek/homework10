package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.*;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 10 Demo: Iterator + Mediator ===\n");


        List<Hero> party = List.of(
                new Hero("Alibi the Brave", 120, 25, 15),
                new Hero("Sanzhar the Wise", 80, 40, 5)
        );

        QuestLog log = new QuestLog();
        log.add(new Quest("Clear Goblin Cave", QuestPriority.NORMAL, 200, false));
        log.add(new Quest("Defeat Ancient Dragon", QuestPriority.URGENT, 5000, true));
        log.add(new Quest("Retrieve Stolen Relic", QuestPriority.HIGH, 1200, false));
        log.add(new Quest("Escort Merchant", QuestPriority.LOW, 100, false));
        log.add(new Quest("Protect Guild Hall", QuestPriority.URGENT, 3000, true));


        GuildHall hall = new GuildHall();
        new Captain("Erwin", hall);
        new Scout("Levi", hall);
        new Healer("Sakura", hall);
        new Quartermaster("Hange", hall);
        new Loremaster("Willow", hall); // Part 4

        CouncilEngine engine = new CouncilEngine();
        CouncilRunResult result = engine.runCouncil(party, log, hall);


        System.out.println("\n--- Part 4: Highest Reward Quests First ---");
        QuestIterator rewardIt = log.rewardSorted();
        while (rewardIt.hasNext()) {
            System.out.println(rewardIt.next());
        }

        System.out.println("\n" + result);
    }
}