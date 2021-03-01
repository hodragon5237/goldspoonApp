import axios from 'axios';

const URL = "https://teachablemachine.withgoogle.com/models/rWE0islp7/";

const modelURL = URL + "model.json";
const metadataURL = URL + "metadata.json";

class ModelService {

    predict(image) {
        model = await tmImage.load(modelURL, metadataURL);
        maxPredictions = model.getTotalClasses();

        const prediction = await model.predict(image, false);
    }

}
