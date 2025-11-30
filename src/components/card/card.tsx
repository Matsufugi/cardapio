import "./card.css";

interface CardProps {
        price: number,
        name: string,
        imageUrl: string,
        description: string
}

export function Card({price, name, imageUrl, description} : CardProps) {
    return (
        <div className="card">
            <img src={imageUrl}/>
            <h2>{name} </h2>
            <p>{price}</p>
            <p>{description} </p>
        </div>
    )
}