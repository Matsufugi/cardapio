import { useEffect, useState } from "react"
import { useFoodDataMutate } from "../../hooks/useFoodDataMutate";
import type { FoodData } from "../../interface/FoodData";
import './modal.css';

interface InputProps {
    label: string,
    value: string | number,
    updateValue(value: any): void
}

interface ModalProps {
    closeModal(): void
}

const Input = ({ label, value, updateValue }: InputProps) => {
    return (
        <>
            <label>{label}</label>
            <input value={value} onChange={event => updateValue(event.target.value)}></input>
        </>
    )
}

export function CreateModal({ closeModal }: ModalProps){
    const [name, setName] = useState("");
    const [price, setPrice] = useState(0);
    const [imageUrl, setImageUrl] = useState("");
    const [description, setDescription] = useState("");

    const { mutate, isSuccess } = useFoodDataMutate();


    const submit = () => {
        const foodData: FoodData = {
            name,
            price,
            imageUrl,
            description
        }
        mutate(foodData)
    }

    useEffect(() => {
        if(!isSuccess) return 
        closeModal();
    }, [isSuccess])


    return (
        <div className="modal-overlay">
            <div className="modal-body">
                <h2>Cadastre um novo item no cardápio</h2>
                <form className="input-container">
                    <Input label="Name" value={name} updateValue={setName}/>
                    <Input label="Price" value={price} updateValue={setPrice}/>
                    <Input label="Image" value={imageUrl} updateValue={setImageUrl}/>
                    <Input label="Description" value={description} updateValue={setDescription}/>
                </form>
                <button onClick={submit} className="btn-secondary">
                    postar
                </button>
            </div>
        </div>

    )
}
