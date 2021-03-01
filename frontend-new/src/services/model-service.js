import axios from 'axios';
import * as tf from '@tensorflow/tfjs';
import * as tmImage from '@teachablemachine/image';

const URL = "https://teachablemachine.withgoogle.com/models/rWE0islp7/";

const modelURL = URL + "model.json";
const metadataURL = URL + "metadata.json";

class ModelService {

    async predict(image) {
        var model = await tmImage.load(modelURL, metadataURL);
        var maxPredictions = model.getTotalClasses();

        console.log(model);
        console.log(image);

        const prediction = await model.predict(image, false);

        var resultMessage;
        
        if(prediction[0].probability>=0.8){
            resultMessage = "돈이 저절로 따라붙는<br>당신은 미래의 대기업 회장님!"
        }else if(prediction[0].probability>=0.6){
            resultMessage = "재물운이 이정도로 받쳐준다면<br>앞으로 먹고 살 걱정은 없겠습니다!"
        }else if(prediction[0].probability>=0.4){
            resultMessage = "너무 잘나가도 걱정<br>너무 안되도 걱정<br>인생은 중간이 가장 좋은 법!"
        }else if(prediction[0].probability>=0.2){
            resultMessage = "조금 약할 뿐이지<br>없는 것은 아니니!<br>나에게도 희망은 있다!"
        }else{
            resultMessage = "금수저가 아니면 어떠하리!<br>이 한 몸 불사른다면,<br>나도 부자가 될 수 있다!"
        }

        return resultMessage;
    }

}

export default ModelService;
