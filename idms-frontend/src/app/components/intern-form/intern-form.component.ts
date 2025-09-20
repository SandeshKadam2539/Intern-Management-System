import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BatchService } from '../../services/batch.service';
import { InternService } from '../../services/intern.service';
import { Batch } from '../../models/batch.model';

@Component({
    selector: 'app-intern-form',
    templateUrl: './intern-form.component.html',
    styleUrls: ['./intern-form.component.css'],
    standalone: false
})
export class InternFormComponent implements OnInit {
  form!: FormGroup;
  batches: Batch[] = [];

  constructor(
    private fb: FormBuilder,
    private batchService: BatchService,
    private internService: InternService
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      mobile: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      idCardType: ['FREE', Validators.required],
      dateOfJoining: ['', Validators.required],
      batchId: [null, Validators.required]
    });

    this.batchService.getAll().subscribe({
      next: b => this.batches = b,
      error: err => console.error('Batch load error', err)
    });
  }

  submit() {
    if (this.form.invalid) return;
    const raw = this.form.value;
    const payload = {
      ...raw,
      dateOfJoining: new Date(raw.dateOfJoining).toISOString().slice(0,10)
    };
    this.internService.create(payload).subscribe({
      next: res => {
        alert('Intern Created: ' + (res.internId ?? ''));
        this.form.reset({ idCardType: 'FREE' });
      },
      error: err => {
        console.error(err);
        alert('Error creating intern');
      }
    });
  }
}
