package sorucoder.librocraft.main.rendering.tileentity;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import sorucoder.librocraft.main.LibroCraft;
import sorucoder.librocraft.main.block.tileentity.ArmorStandTileEntity;
import sorucoder.librocraft.main.rendering.tileentity.util.ModelDummy;

import javax.annotation.Nullable;
import java.util.Map;

public class ArmorStandTileEntityRenderer extends TileEntityRenderer<ArmorStandTileEntity> {

    private AbstractClientPlayerEntity alex;

    private EntityRendererManager renderManager;

    private final ModelDummy modelLeggings =  new ModelDummy(1.0f);
    private final ModelDummy modelArmor =  new ModelDummy(1.0F);


    private IVertexBuilder buffer;

    private static final Map<String, ResourceLocation> ARMOR_TEXTURE_RES_MAP = Maps.newHashMap();


    public ArmorStandTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);

    }

    @Override
    public void render(ArmorStandTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        //if(alex == null) {
          // this.renderManager = Minecraft.getInstance().getRenderManager();
           //this.alex = new FakeClientPlayer(Minecraft.getInstance().world);
           //this.alex.setPosition(0.0,0.0,0.0);
        //}
        if(tileEntityIn != null) {
            //add if statement to check rotation.
            //this.alex.setItemStackToSlot(EquipmentSlotType.HEAD, tileEntityIn.getStackInSlot(0));
            //this.alex.setItemStackToSlot(EquipmentSlotType.CHEST, tileEntityIn.getStackInSlot(1));
            //this.alex.setItemStackToSlot(EquipmentSlotType.LEGS, tileEntityIn.getStackInSlot(2));
            //this.alex.setItemStackToSlot(EquipmentSlotType.FEET, tileEntityIn.getStackInSlot(3));
           // this.alex.renderYawOffset = 0.0f;
           // this.alex.rotationYawHead = 0.0f;
            Vec3d vec3d = Vec3d.ZERO;
            double x = 0.5 + vec3d.x;
            double y = 0.07 + vec3d.y;
            double z = 0.5 + vec3d.z;
            matrixStackIn.push();
            RenderSystem.enableLighting();
            RenderSystem.enableBlend();
            RenderSystem.enableCull();
            //this.buffer.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.buffer = bufferIn.getBuffer(RenderType.getTranslucent());
            matrixStackIn.translate(x,y,z);
            matrixStackIn.rotate(new Quaternion(0f,0f,180f,true));
            //matrixStackIn.scale(2f,2f,2f);
            //matrixStackIn.translate(x,y+2,z);
            //matrixStackIn.translate(vec3d.x, vec3d.y,vec3d.z);
            //matrixStackIn.translate(-vec3d.getX(), -vec3d.getY(),-vec3d.getZ());
            //matrixStackIn.rotate(new Quaternion(new Vector3f((float)x, (float)y, (float)z), 180, true));
            this.renderArmorPart(matrixStackIn, bufferIn, tileEntityIn, 0, 0, partialTicks, 0, 0, 0, EquipmentSlotType.CHEST, combinedLightIn);
            this.renderArmorPart(matrixStackIn, bufferIn, tileEntityIn, 0, 0, partialTicks, 0, 0, 0, EquipmentSlotType.LEGS, combinedLightIn);
            this.renderArmorPart(matrixStackIn, bufferIn, tileEntityIn, 0, 0, partialTicks, 0, 0, 0, EquipmentSlotType.FEET, combinedLightIn);
            this.renderArmorPart(matrixStackIn, bufferIn, tileEntityIn, 0, 0, partialTicks, 0, 0, 0, EquipmentSlotType.HEAD, combinedLightIn);
           // matrixStackIn.translate(-vec3d.getX(), -vec3d.getY(),-vec3d.getZ());

            //this.renderManager.renderEntityStatic((Entity) this.alex, 0.5D, 0.07D, 0.5D, 0.0f, partialTicks, matrixStackIn, bufferIn, combinedLightIn);
            RenderSystem.disableCull();
            RenderSystem.disableBlend();
            RenderSystem.disableLighting();
            matrixStackIn.pop();
        }
    }
    private void renderArmorPart(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, ArmorStandTileEntity entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, EquipmentSlotType slotIn, int packedLightIn) {
        ItemStack itemstack = entityLivingBaseIn.getStackInSlot(convertEquipmentSlotTypeToInt(slotIn));
        if (itemstack.getItem() instanceof ArmorItem) {
            ArmorItem armoritem = (ArmorItem) itemstack.getItem();
            if (armoritem.getEquipmentSlot() == slotIn) {
                ModelDummy a = (ModelDummy) this.getModelFromSlot(slotIn);
                if (a == null) return;
               // ((ModelDummy) a.getEntityModel()).setModelAttributes(a);
                this.setModelSlotVisible(a, slotIn);
                try {
                    a.setRotationAngles(null, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                } catch(NullPointerException e) {
                    LibroCraft.getLOGGER().debug("um, no one cares");

                }
                boolean flag1 = itemstack.hasEffect();
                boolean legSlot = slotIn == EquipmentSlotType.LEGS;
                if (armoritem instanceof IDyeableArmorItem) {
                    int i = ((IDyeableArmorItem) armoritem).getColor(itemstack);
                    float f = (float) (i >> 16 & 255) / 255.0F;
                    float f1 = (float) (i >> 8 & 255) / 255.0F;
                    float f2 = (float) (i & 255) / 255.0F;
                    renderModel(matrixStackIn, bufferIn, packedLightIn, armoritem, flag1, a, legSlot, f, f1, f2, null);
                    renderModel(matrixStackIn, bufferIn, packedLightIn, armoritem, flag1, a, legSlot, 1.0F, 1.0F, 1.0F,"overlay");
                } else {
                    renderModel(matrixStackIn, bufferIn, packedLightIn, armoritem, flag1, a, legSlot, 1.0F, 1.0F, 1.0F,null);
                }
            }
        }
    }

  /*  private void setRotations(BipedModel model, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        model.bipedHead.rotateAngleX = headPitch * ((float)Math.PI / 180F);


        model.bipedBody.rotateAngleY = 0.0F;
        model.bipedRightArm.rotationPointZ = 0.0F;
        model.bipedRightArm.rotationPointX = -5.0F;
        model.bipedLeftArm.rotationPointZ = 0.0F;
        model.bipedLeftArm.rotationPointX = 5.0F;



        model.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
        model.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
        model.bipedRightArm.rotateAngleZ = 0.0F;
        model.bipedLeftArm.rotateAngleZ = 0.0F;
        model.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
        model.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
        model.bipedRightLeg.rotateAngleY = 0.0F;
        model.bipedLeftLeg.rotateAngleY = 0.0F;
        model.bipedRightLeg.rotateAngleZ = 0.0F;
        model.bipedLeftLeg.rotateAngleZ = 0.0F;

        model.bipedRightArm.rotateAngleY = 0.0F;
        model.bipedRightArm.rotateAngleZ = 0.0F;






        model.bipedBody.rotateAngleX = 0.0F;
        model.bipedRightLeg.rotationPointZ = 0.1F;
        model.bipedLeftLeg.rotationPointZ = 0.1F;
        model.bipedRightLeg.rotationPointY = 12.0F;
        model.bipedLeftLeg.rotationPointY = 12.0F;
        model.bipedHead.rotationPointY = 0.0F;
        model.bipedBody.rotationPointY = 0.0F;
        model.bipedLeftArm.rotationPointY = 2.0F;
        model.bipedRightArm.rotationPointY = 2.0F;


        model.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        model.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        model.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        model.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;




        model.bipedHeadwear.copyModelAngles(model.bipedHead);
}*/

    private void renderModel(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, ArmorItem armorItemIn, boolean glintIn, ModelDummy modelIn, boolean legSlotIn, float red, float green, float blue, @Nullable String overlayIn) {
        renderArmor(matrixStackIn, bufferIn, packedLightIn, glintIn, modelIn, red, green, blue, this.getArmorResource(armorItemIn, legSlotIn, overlayIn));
    }
    private void renderArmor(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, boolean glintIn, ModelDummy modelIn, float red, float green, float blue, ResourceLocation armorResource) {
        IVertexBuilder ivertexbuilder = ItemRenderer.getBuffer(bufferIn, RenderType.getEntityCutoutNoCull(armorResource), false, glintIn);
        modelIn.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, red, green, blue, 1.0F);
    }

    public ModelDummy getModelFromSlot(EquipmentSlotType slotIn) {
        return (ModelDummy)(this.isLegSlot(slotIn) ? this.modelLeggings : this.modelArmor);
    }

    private boolean isLegSlot(EquipmentSlotType slotIn) {
        return slotIn == EquipmentSlotType.LEGS;
    }


    protected void setModelSlotVisible(ModelDummy modelIn, EquipmentSlotType slotIn) {
        this.setModelVisible(modelIn);
        switch(slotIn) {
            case HEAD:
                modelIn.bipedHead.showModel = true;
                modelIn.bipedHeadwear.showModel = true;
                break;
            case CHEST:
                modelIn.bipedBody.showModel = true;
                modelIn.bipedRightArm.showModel = true;
                modelIn.bipedLeftArm.showModel = true;
                break;
            case LEGS:
                modelIn.bipedBody.showModel = true;
                modelIn.bipedRightLeg.showModel = true;
                modelIn.bipedLeftLeg.showModel = true;
                break;
            case FEET:
                modelIn.bipedRightLeg.showModel = true;
                modelIn.bipedLeftLeg.showModel = true;
        }

    }

    private ResourceLocation getArmorResource(ArmorItem armor, boolean legSlotIn, @Nullable String suffixOverlayIn) {
        String s = "textures/models/armor/" + armor.getArmorMaterial().getName() + "_layer_" + (legSlotIn ? 2 : 1) + (suffixOverlayIn == null ? "" : "_" + suffixOverlayIn) + ".png";
        return ARMOR_TEXTURE_RES_MAP.computeIfAbsent(s, ResourceLocation::new);
    }


    protected void setModelVisible(ModelDummy model) {
        model.setVisible(false);
    }

    private static int convertEquipmentSlotTypeToInt(EquipmentSlotType slotType) {
       return slotType.getSlotIndex() - 1;
    }



}
