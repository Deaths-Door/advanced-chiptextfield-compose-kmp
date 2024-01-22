Pod::Spec.new do |spec|
    spec.name                     = 'advanced_chiptextfield_compose'
    spec.version                  = '1.0.0'
    spec.homepage                 = 'https://github.com/Deaths-Door/advanced-chiptextfield-compose-kmp'
    spec.source                   = { :http=> ''}
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = 'Discover a dynamic Editable Chip Text Field implementation for Kotlin Multiplatform Mobile (KMM) applications using Jetpack Compose. This repository showcases a versatile UI component that enables users to create chips by typing and converting text entries. Harnessing the power of Jetpack Compose, this project provides a cross-platform solution for seamlessly managing chip-like elements without the need for images or complex UI elements.
'
    spec.vendored_frameworks      = 'build/cocoapods/framework/shared.framework'
    spec.libraries                = 'c++'
    spec.ios.deployment_target = '14.1'
                
                
    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':advanced-chiptextfield-compose',
        'PRODUCT_MODULE_NAME' => 'shared',
    }
                
    spec.script_phases = [
        {
            :name => 'Build advanced_chiptextfield_compose',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :script => <<-SCRIPT
                if [ "YES" = "$OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED" ]; then
                  echo "Skipping Gradle build task invocation due to OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED environment variable set to \"YES\""
                  exit 0
                fi
                set -ev
                REPO_ROOT="$PODS_TARGET_SRCROOT"
                "$REPO_ROOT/../gradlew" -p "$REPO_ROOT" $KOTLIN_PROJECT_PATH:syncFramework \
                    -Pkotlin.native.cocoapods.platform=$PLATFORM_NAME \
                    -Pkotlin.native.cocoapods.archs="$ARCHS" \
                    -Pkotlin.native.cocoapods.configuration="$CONFIGURATION"
            SCRIPT
        }
    ]
                
end