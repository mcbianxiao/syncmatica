package ch.endte.syncmatica.network.channels;

import ch.endte.syncmatica.network.payload.PacketType;
import ch.endte.syncmatica.network.payload.SyncByteBuf;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public record SyncModifyFinish(SyncByteBuf byteBuf) implements CustomPayload
{
    public static final Id<SyncModifyFinish> TYPE = new Id<>(PacketType.MODIFY_FINISH.getId());
    public static final PacketCodec<PacketByteBuf, SyncModifyFinish> CODEC = CustomPayload.codecOf(SyncModifyFinish::write, SyncModifyFinish::new);

    public SyncModifyFinish(PacketByteBuf input)
    {
        this(new SyncByteBuf(input.readBytes(input.readableBytes())));
    }

    private void write(PacketByteBuf output) { output.writeBytes(byteBuf); }

    @Override
    public Id<? extends CustomPayload> getId() { return TYPE; }
}
