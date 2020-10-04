package sorucoder.librocraft.main.rendering.tileentity.util;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;

import java.util.UUID;


public class FakeClientPlayer extends AbstractClientPlayerEntity {
   private static GameProfile profile = new GameProfile(UUID.randomUUID(), "libroalex");

    public FakeClientPlayer(ClientWorld world) {
        super(world, profile);
        this.setInvisible(true);
    }
}
