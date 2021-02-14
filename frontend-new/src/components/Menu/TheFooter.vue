<template>
    <footer class="footer has-cards">
        <div class="container container-lg">
            <div class="row">
            </div>
        </div>
        <div class="container">
            <div class="row row-grid align-items-center my-md">
                <div class="col-lg-6">
                    <div class="copy_right">© 2021. 827Project all rights reserved.</div>
                </div>
            </div>
            <hr>
            <div class="row align-items-center justify-content-md-between">
            </div>
        </div>
    </footer>
</template>
<script>
export default {
  name: 'app-footer',
  data() {
    return {
      year: new Date().getFullYear()
    }
  }
};
</script>
<style>
</style>