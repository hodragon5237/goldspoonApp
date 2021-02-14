<template>
    <div>
        <div id="_" style="transform-origin: 0px 0px;">
            <nav class="navbar navbar-expand-lg navbar-light nav-distance">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">재미로 보는 관상 1탄</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Features</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Pricing</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <section class="section">
                <h1 class="title">재물운 테스트</h1>
                <h2 class="subtitle">내가 타고난 금수저의 기운은?</h2>
            </section>

            <div class="container file-upload">
                <div class="image-upload-wrap">
                    <input class="file-upload-input" type='file' onchange="readURL(this);" accept="image/*" />
                    <div class="_image_box">+ image</div>
                    <div class="drag-text">
                        <h3 class="mb-5 pb-5 upload-text">얼굴 사진을 업로드 해 주세요!</h3>
                    </div>
                </div>
                <div class="file-upload-content">
                    <img class="file-upload-image" id="face-image" src="#" alt="your image" />
                    <div>
                        <button class="btn btn-primary" type="button" disabled>
                            <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                            AI가 지금 당신의 관상을 분석하고 있습니다.
                        </button>
                    </div>
                    <p class="result-message"></p>
                    <div id="label-container"></div>
                    <div class="horizontal-bar-chart">
                            <span id="probability-container"></span>
                    </div>
                    <div class="image-title-wrap">
                        <button type="button" onclick="removeUpload()" class="remove-image">다른 사진으로 다시 시도</button>
                    </div>
                    <!-- Go to www.addthis.com/dashboard to customize your tools -->
                    <div class="addthis_inline_share_toolbox"></div>
                </div>
            </div>
            <div class="ad-banner">
                <ins class="kakao_ad_area" style="display:none;" 
                    data-ad-unit    = "DAN-bnyFAjUAwJde9cuJ" 
                    data-ad-width   = "320" 
                    data-ad-height  = "100"></ins> 
            </div>
            <div class="copy_right">© 2021. 827Project all rights reserved.</div>
        </div>
        <div id="disqus_thread"></div>
    </div>
</template>
<script>
export default {};
</script>
<style>
</style>