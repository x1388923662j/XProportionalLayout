# XProportionalLayout可以定义比例的Layout使用：compile 'cn.xuzhijun:xproportional-layout:1.0.0'包括：  ProportionalFrameLayout  ProportionalLinearLayout  ProportionalRelativeLayout  ProportionalImageView  使用```xml<cn.xuzhijun.proportional.ProportionalFrameLayout    android:layout_width="match_parent"    android:layout_height="wrap_content"    app:scaleHeight="9"    app:scaleWidth="16">            <cn.xuzhijun.proportional.ProportionalImageView        android:layout_width="match_parent"        android:layout_height="wrap_content"        android:src="@mipmap/ic_launcher"        app:scaleHeight="1"        app:scaleWidth="1"/>        <!-- your view -->    </cn.xuzhijun.proportional.ProportionalFrameLayout>```