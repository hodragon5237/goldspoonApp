<template>
  <div id="app">
      <the-layout>
        <router-view />
      </the-layout>
  </div>
</template>
<script>
import TheLayout from '@/layouts/TheLayout';

export default {
    name: 'App',
    components: { TheLayout },
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
