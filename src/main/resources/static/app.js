function createReview() {
    const [title, setTitle] = React.useState('');
    const [rating, setRating] = React.useState(0);
    const [description, setDescription] = React.useState('');
    const [showSuccess, setShowSuccess] = react.useState(false);

    const handleSubmission = async (event) => {
        event.preventDefault();
        const response = await fetch('http://localhost:8080/reviews/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                title: title,
                rating: rating,
                description: description
            }),
        });
        if (response.ok) {
            setShowSuccess(true);
        }
    }

    return React.createElement('div', null,
        React.createElement('h1', null, 'Create a Review'),
        showSuccess ? React.createElement('p', null, 'Review created successfully') : null,
        React.createElement('form', {onSubmit: handleSubmission},
            React.createElement('input',
                {
                    value: title,
                    onChange: event => setTitle(event.target.value),
                    placeholder: "Title",
                    style: {marginRight: '10px'}
                }),
            React.createElement('input',
                {
                    value: rating,
                    onChange: event => setRating(event.target.value),
                    placeholder: "Rating",
                    style: {marginRight: '10px'}
                }),
            React.createElement('input',
                {
                    value: description,
                    onChange: event => setDescription(event.target.value),
                    placeholder: "Description",
                    style: {marginRight: '10px'}
                }),
            React.createElement('button', {type: 'submit'}, 'Submit')
        ),
    )
}

ReactDOM.render(React.createElement(createReview), document.getElementById('root'));
