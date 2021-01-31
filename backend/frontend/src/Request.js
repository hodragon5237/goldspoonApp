import { get, post } from 'axios';
import resolve from 'resolve';

export function postRequest (url, data, config) {

    const formData = {
        "transactionTime": Date.now(),
        "data": data
    }

    return new Promise((resolve, reject)  => {
        post(url, formData, config)
            .then(response => {
                resolve(response);
            })
            .catch(error => {
                reject(error);
            })
    })
}