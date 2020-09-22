package surocoder.librocraft.main.rendering.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import surocoder.librocraft.main.block.tileentity.ArmorStandTileEntity;

public class ArmorStandTileEntityRenderer extends TileEntityRenderer<ArmorStandTileEntity> {


    public ArmorStandTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    private IVertexBuilder buffer;

    @Override
    public void render(ArmorStandTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        if(bufferIn.getBuffer(RenderType.getCutoutMipped()) != buffer) {
            this.buffer = bufferIn.getBuffer(RenderType.getCutoutMipped());
        }

    }
}
