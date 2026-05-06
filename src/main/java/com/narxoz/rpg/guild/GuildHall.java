package com.narxoz.rpg.guild;
import java.util.*;

public class GuildHall implements GuildMediator {
    private final Map<String, List<GuildMember>> membersByTopic = new HashMap<>();
    private int lastDispatchCount = 0;

    @Override
    public void register(GuildMember member) {

        if (member instanceof Captain) addSubscriber("orders", member);
        if (member instanceof Scout) addSubscriber("scouting", member);
        if (member instanceof Healer) addSubscriber("healing", member);
        if (member instanceof Quartermaster) addSubscriber("supplies", member);
        if (member instanceof Loremaster) addSubscriber("lore", member);


        addSubscriber("urgent", member);
    }

    @Override
    public void dispatch(String topic, GuildMember from, String payload) {
        List<GuildMember> recipients = subscribersFor(topic);
        lastDispatchCount = 0;
        for (GuildMember m : recipients) {
            if (m != from) {
                m.receive(topic, from, payload);
                lastDispatchCount++;
            }
        }
    }

    public int getLastDispatchCount() { return lastDispatchCount; }

    protected void addSubscriber(String topic, GuildMember member) {
        membersByTopic.computeIfAbsent(topic, k -> new ArrayList<>()).add(member);
    }

    protected List<GuildMember> subscribersFor(String topic) {
        return membersByTopic.getOrDefault(topic, List.of());
    }
}