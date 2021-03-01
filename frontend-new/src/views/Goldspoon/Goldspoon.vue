<template>
    <div>
        <section class="section">
            <h1 class="title">재물운 테스트</h1>
            <h2 class="subtitle">내가 타고난 금수저의 기운은?</h2>
        </section>

        <div class="container file-upload">
            <div class="large-12 medium-12 small-12 cell">
                <label>이미지 파일 선택
                    <input class="file-upload-input" type='file' ref='file' v-on:change="readURL();" accept="image/*" />
                </label>
                    <h3 class="mb-5 pb-5 upload-text">얼굴 사진을 업로드 해 주세요!</h3>
                </div>
        </div>

        <div class="file-upload-content">
            <img class="file-upload-image" ref="faceImage" :src="fileSrc" alt="your image" />

            <p class="result-message"></p>
            <div id="label-container"></div>
            <div class="horizontal-bar-chart">
                <span id="probability-container"></span>
            </div>
        </div>

        

        <spinner :loading="isLoading" :msg="loadingMsg"></spinner>
    </div>

    
</template>

<script>
import Spinner from '../../components/custom/Spinner';
import ModelService from '../../services/model-service';

export default {
  components: { Spinner },

    name: 'Goldspoon',

    data() {
        return {
            file: null,
            fileSrc: "#",
            image: null,
            isLoading: false,
            loadingMsg: "관상 분석중.."
        }
    },

    methods: {
        readURL() {
            this.file = this.$refs.file.files[0];
            
            if (this.file) {
                var reader = new FileReader();

                reader.onload = (e) => {
                    this.fileSrc = e.target.result;
                }

                reader.readAsDataURL(this.file);
                console.log(this.fileSrc);

                this.toggleSpinner(true);

                var image = this.$refs.faceImage;

                const modelService = new ModelService();

                modelService.predict(image).then(
                    (resultMsg) => {
                        console.log(resultMsg);
                        this.toggleSpinner(false);
                    }
                )
            }
        },

        toggleSpinner(status) {
            this.isLoading = status;
        }
    }

};
</script>
<style>
</style>