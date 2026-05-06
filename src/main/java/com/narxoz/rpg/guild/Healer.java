package com.narxoz.rpg.guild;

public class Healer extends GuildMember {
    public Healer(String name, GuildMediator mediator) { super(name, mediator); }
    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("[Healer " + getName() + "] Preparing remedies for: " + payload);
    }
}