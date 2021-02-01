import { get, post } from 'axios';
export const requestPost = (url, data, config) => {

    const formData = {
        "transactionTime": "",
        "data": data
    }

    console.log(formData);

    post(url, formData, config)
        .then((res) => {
            return res;
        })
}