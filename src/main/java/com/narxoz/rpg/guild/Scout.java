package com.narxoz.rpg.guild;

public class Scout extends GuildMember {
    public Scout(String name, GuildMediator mediator) { super(name, mediator); }
    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("[Scout " + getName() + "] Scouting report updated based on: " + payload);
    }
}