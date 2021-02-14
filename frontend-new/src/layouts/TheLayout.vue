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
    computed: {
        layout() {
            const layout = this.$route.meta.layout || 'DefaultLayout';
            return () => import(`@/layouts/${layout}.vue`)
        }
    }
}
</script>