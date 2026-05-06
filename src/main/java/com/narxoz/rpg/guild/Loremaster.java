package com.narxoz.rpg.guild;

public class Loremaster extends GuildMember {
    public Loremaster(String name, GuildMediator mediator) { super(name, mediator); }
    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("[Loremaster " + getName() + "] Recording lore/urgent event: " + payload);
    }
}