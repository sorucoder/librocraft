package sorucoder.librocraft.main.rendering.tileentity.util;

import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nullable;

public class ModelDummy extends BipedModel<AbstractClientPlayerEntity> {
    public ModelDummy(float size) {
        super(size);
    }

    @Override
    public void setRotationAngles(@Nullable AbstractClientPlayerEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.bipedHead.rotateAngleX = headPitch * ((float)Math.PI / 180F);


        this.bipedBody.rotateAngleY = 0.0F;
        this.bipedRightArm.rotationPointZ = 0.0F;
        this.bipedRightArm.rotationPointX = -5.0F;
        this.bipedLeftArm.rotationPointZ = 0.0F;
        this.bipedLeftArm.rotationPointX = 5.0F;



        this.bipedRightArm.rotateAngleX = 0;//MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
        this.bipedLeftArm.rotateAngleX = 0;//MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
        this.bipedRightArm.rotateAngleZ = 0.0F;
        this.bipedLeftArm.rotateAngleZ = 0.0F;
        this.bipedRightLeg.rotateAngleX = 0;//MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
        this.bipedLeftLeg.rotateAngleX = 0;//MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
        this.bipedRightLeg.rotateAngleY = 0.0F;
        this.bipedLeftLeg.rotateAngleY = 0.0F;
        this.bipedRightLeg.rotateAngleZ = 0.0F;
        this.bipedLeftLeg.rotateAngleZ = 0.0F;

        this.bipedRightArm.rotateAngleY = 0.0F;
        this.bipedRightArm.rotateAngleZ = 0.0F;






        this.bipedBody.rotateAngleX = 0.0F;
        this.bipedRightLeg.rotationPointZ = 0.1F;
        this.bipedLeftLeg.rotationPointZ = 0.1F;
        this.bipedRightLeg.rotationPointY = 12.0F;
        this.bipedLeftLeg.rotationPointY = 12.0F;
        this.bipedHead.rotationPointY = 0.0F;
        this.bipedBody.rotationPointY = 0.0F;
        this.bipedLeftArm.rotationPointY = 2.0F;
        this.bipedRightArm.rotationPointY = 2.0F;


        this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;




        this.bipedHeadwear.copyModelAngles(this.bipedHead);
    }
}
