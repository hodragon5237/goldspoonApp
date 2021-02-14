<template>
    <component :is="layout" >
        <slot  />
    </component>
</template>

<script>
import { computed } from '@vue/composition-api';
import DefaultLayout from './DefaultLayout';
import MobileLayout from './MobileLayout';

export default {
    name: 'TheLayout',
    components: {
        DefaultLayout,
        MobileLayout,
    },
    setup(props, { root }){
        const layout = computed(() => root.$route.meta.layout || 'DefaultLayout' );

        console.log(layout);

        return {
            layout
        }
    }
}
</script>